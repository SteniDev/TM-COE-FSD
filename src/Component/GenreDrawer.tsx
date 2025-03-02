import { 
    Button, 
    Drawer, 
    DrawerBody, 
    DrawerContent, 
    DrawerHeader, 
    DrawerOverlay, 
    useDisclosure,
    List,
    ListItem,
    Flex,
    Image,
    Text,
    Box,
    Spinner,
    Center
  } from "@chakra-ui/react";
  import React, { useEffect, useState } from "react";
  import { getGenres, Genre } from "./getGenres"; // Import the function from separate file
  
  interface GenreDrawerProps {
    onSelectGenre?: (genreId: number) => void;
  }
  
  function GenreDrawer({ onSelectGenre }: GenreDrawerProps) {
    const { isOpen, onOpen, onClose } = useDisclosure();
    const [genres, setGenres] = useState<Genre[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
  
    useEffect(() => {
      // Fetch genres when component mounts
      const fetchGenres = async () => {
        setLoading(true);
        const genreData = await getGenres();
        setGenres(genreData);
        setLoading(false);
      };
  
      fetchGenres();
    }, []);
  
    const handleGenreClick = (genreId: number) => {
      if (onSelectGenre) {
        onSelectGenre(genreId);
      }
      onClose();
    };
  
    return (
      <>
        <Button colorScheme='blue' onClick={onOpen} leftIcon={<Text>🎮</Text>}>
          Browse Genres
        </Button>
        
        <Drawer placement="left" onClose={onClose} isOpen={isOpen}>
          <DrawerOverlay />
          <DrawerContent>
            <DrawerHeader borderBottomWidth='1px'>Game Genres</DrawerHeader>
            <DrawerBody padding={0}>
              {loading ? (
                <Center h="100px">
                  <Spinner />
                </Center>
              ) : (
                <List spacing={0}>
                  {genres.map((genre) => (
                    <ListItem 
                      key={genre.id} 
                      onClick={() => handleGenreClick(genre.id)}
                      cursor="pointer"
                      _hover={{ bg: "gray.700" }}
                      borderBottomWidth="1px"
                    >
                      <Flex p={3}>
                        <Image 
                          src={genre.image_background} 
                          alt={genre.name}
                          boxSize="60px"
                          objectFit="cover"
                          borderRadius="md"
                          mr={3}
                        />
                        <Box>
                          <Text fontWeight="bold">{genre.name}</Text>
                          <Text fontSize="sm" color="gray.400">
                            {genre.games_count.toLocaleString()} games
                          </Text>
                        </Box>
                      </Flex>
                    </ListItem>
                  ))}
                </List>
              )}
            </DrawerBody>
          </DrawerContent>
        </Drawer>
      </>
    );
  }
  
  export default GenreDrawer;