import { Box, Text, Center } from "@chakra-ui/react";

const Footer = () => {
  return (
    <Box as="footer" py={4} bg="gray.800" color="white" mt={8}>
      <Center>
        <Text fontSize="sm">© {new Date().getFullYear()} Dragon E-Sports. All Rights Reserved.</Text>
      </Center>
    </Box>
  );
};

export default Footer;
