import axios from 'axios';

// Define the types for genre data
export interface Genre {
  id: number;
  name: string;
  slug: string;
  games_count: number;
  image_background: string;
}

interface GenresResponse {
  count: number;
  next: string | null;
  previous: string | null;
  results: Genre[];
}

// Function to fetch genres from the RAWG API
export const getGenres = async (): Promise<Genre[]> => {
  const API_KEY = 'da923c8f6d0540259012bb69fd8caf68';
  const API_URL = 'https://api.rawg.io/api/genres';
  
  try {
    const response = await axios.get<GenresResponse>(API_URL, {
      params: {
        key: API_KEY
      }
    });
    
    return response.data.results;
  } catch (error) {
    console.error('Error fetching genres:', error);
    return [];
  }
};
