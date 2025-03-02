import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Box, SimpleGrid, Spinner, Center, Text, Container, Heading, Flex } from '@chakra-ui/react';
import { GameCard } from './GameCard';
import Navbar from './NavBar';
import GenreDrawer from './GenreDrawer';
import Footer from './Footer';
import Pagination from './Pagination';

interface Game {
  id: number;
  name: string;
  background_image: string;
}

interface ApiResponse {
  count: number;
  next: string | null;
  previous: string | null;
  results: Game[];
}

const GameList: React.FC = () => {
  const [games, setGames] = useState<Game[]>([]);
  const [filteredGames, setFilteredGames] = useState<Game[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);
  const [searchTerm, setSearchTerm] = useState<string>('');
  const [selectedGenreId, setSelectedGenreId] = useState<number | null>(null);
  const [activeGenreName, setActiveGenreName] = useState<string>('All Games');

  const [currentPage, setCurrentPage] = useState<number>(1);
  const [totalPages, setTotalPages] = useState<number>(1);

  const API_KEY = 'da923c8f6d0540259012bb69fd8caf68';
  const API_URL = 'https://api.rawg.io/api/games';

  const fetchGames = async (genreId: number | null = null, page: number = 1) => {
    try {
      setLoading(true);
      
      const params: any = {
        key: API_KEY,
        page_size: 21,
        page: page
      };
      
      if (genreId) {
        params.genres = genreId;
      }
      
      const response = await axios.get<ApiResponse>(API_URL, { params });

      const gameData = response.data.results.map((game) => ({
        id: game.id,
        name: game.name,
        background_image: game.background_image
      }));

      setGames(gameData);
      setFilteredGames(gameData);
      setTotalPages(Math.ceil(response.data.count / 20));
      setLoading(false);
    } catch (error) {
      console.error('Error fetching games:', error);
      setError('Failed to fetch games. Please try again later.');
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchGames();
  }, [currentPage]);

  const handlePageChange = (page: number) => {
    setCurrentPage(page);
    fetchGames(selectedGenreId, page);
  };

  const handleGenreSelect = async (genreId: number) => {
    setSelectedGenreId(genreId);
    
    try {
      const response = await axios.get(`https://api.rawg.io/api/genres/${genreId}`, {
        params: { key: API_KEY }
      });
      setActiveGenreName(response.data.name);
    } catch (error) {
      console.error('Error fetching genre details:', error);
    }
    
    setCurrentPage(1);
    fetchGames(genreId, 1);
  };

  const handleSearch = (term: string) => {
    setSearchTerm(term);
    
    if (!term.trim()) {
      setFilteredGames(games);
      return;
    }
    
    const filtered = games.filter(game => 
      game.name.toLowerCase().includes(term.toLowerCase())
    );
    setFilteredGames(filtered);
  };

  const handleResetFilter = () => {
    setSelectedGenreId(null);
    setActiveGenreName('All Games');
    setCurrentPage(1);
    fetchGames();
    if (searchTerm) {
      setSearchTerm('');
    }
  };

  return (
    <Box minH="100vh">
      <Navbar onSearch={handleSearch} onResetFilter={handleResetFilter} />
      
      <Flex>
        <Box pt={6} pl={4}>
          <GenreDrawer onSelectGenre={handleGenreSelect} />
        </Box>
        
        <Container maxW="container.xl" pt={6} pb={8}>
          <Heading size="lg" mb={6} textAlign="center">
            {activeGenreName}
          </Heading>
          
          {loading ? (
            <Center h="300px">
              <Spinner size="xl" />
            </Center>
          ) : error ? (
            <Center h="300px">
              <Text color="red.500">{error}</Text>
            </Center>
          ) : filteredGames.length === 0 ? (
            <Center h="300px">
              <Text fontSize="lg">No games found. Try a different search term or genre.</Text>
            </Center>
          ) : (
            <>
              <SimpleGrid columns={{ base: 1, md: 2, lg: 3 }} spacing={6} px={4}>
                {filteredGames.map((game) => (
                  <GameCard key={game.id} title={game.name} imageUrl={game.background_image} />
                ))}
              </SimpleGrid>

              <Pagination 
                currentPage={currentPage} 
                totalPages={totalPages} 
                onPageChange={handlePageChange} 
              />
            </>
          )}
        </Container>
      </Flex>

      <Footer />
    </Box>
  );
};

export default GameList;
