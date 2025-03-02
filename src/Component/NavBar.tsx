import React, { useState } from 'react';
import logo from '../assets/logo.png'; // Adjust path based on your file structure
import {
  Box,
  Flex,
  Input,
  InputGroup,
  InputLeftElement,
  useColorMode,
  IconButton,
  Image,
  Spacer
} from '@chakra-ui/react';
import { SearchIcon, MoonIcon, SunIcon } from '@chakra-ui/icons';

interface NavbarProps {
  onSearch: (searchTerm: string) => void;
  onResetFilter?: () => void;
}

const Navbar: React.FC<NavbarProps> = ({ onSearch, onResetFilter }) => {
  const { colorMode, toggleColorMode } = useColorMode();
  const [searchTerm, setSearchTerm] = useState('');

  const handleSearch = (e: React.ChangeEvent<HTMLInputElement>) => {
    const value = e.target.value;
    setSearchTerm(value);
    onSearch(value);
  };

  const handleResetFilter = () => {
    if (onResetFilter) {
      onResetFilter();
    }
  };

  return (
    <Box
      as="nav"
      py={3}
      px={6}
      bg={colorMode === 'dark' ? 'gray.800' : 'white'}
      borderBottomWidth="1px"
      shadow="sm"
      position="sticky"
      top={0}
      zIndex={10}
    >
      <Flex align="center" justify="space-between">
        {/* Left Section - Logo */}
        <Box cursor="pointer" onClick={handleResetFilter}>
          <Image 
            src={logo}  
            alt="Dragon E-Sports" 
            boxSize="50px"
            borderRadius="full"
            transition="transform 0.3s"
            _hover={{ transform: "scale(1.05)" }}
            objectFit="contain"
          />
        </Box>

        {/* Center Section - Search Bar */}
        <Flex flex="1" justify="center">
          <InputGroup maxW={{ base: "100%", md: "400px" }}>
            <InputLeftElement pointerEvents="none">
              <SearchIcon color="gray.400" />
            </InputLeftElement>
            <Input
              placeholder="Search games..."
              value={searchTerm}
              onChange={handleSearch}
              borderRadius="md"
              width="100%"
            />
          </InputGroup>
        </Flex>

        {/* Right Section - Dark Mode Toggle */}
        <IconButton
          aria-label="Toggle dark mode"
          icon={colorMode === 'dark' ? <SunIcon /> : <MoonIcon />}
          onClick={toggleColorMode}
          ml={4}
          size="md"
          variant="ghost"
        />
      </Flex>
    </Box>
  );
};

export default Navbar;
