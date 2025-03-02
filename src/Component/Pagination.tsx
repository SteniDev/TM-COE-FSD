import { Button, ButtonGroup, Flex, Text } from "@chakra-ui/react";

interface PaginationProps {
  currentPage: number;
  totalPages: number;
  onPageChange: (page: number) => void;
}

const Pagination: React.FC<PaginationProps> = ({ currentPage, totalPages, onPageChange }) => {
  const visiblePageNumbers = 5; // Number of pages to show before the ellipsis

  const generatePageNumbers = () => {
    const pages: (number | string)[] = [];
    
    if (totalPages <= visiblePageNumbers) {
      for (let i = 1; i <= totalPages; i++) {
        pages.push(i);
      }
    } else {
      if (currentPage <= 3) {
        pages.push(1, 2, 3, 4, 5, "...", totalPages);
      } else if (currentPage >= totalPages - 2) {
        pages.push(1, "...", totalPages - 4, totalPages - 3, totalPages - 2, totalPages - 1, totalPages);
      } else {
        pages.push(1, "...", currentPage - 1, currentPage, currentPage + 1, "...", totalPages);
      }
    }

    return pages;
  };

  return (
    <Flex justify="center" align="center" mt={6}>
      <ButtonGroup>
        <Button 
          onClick={() => onPageChange(currentPage - 1)} 
          isDisabled={currentPage === 1}
        >
          Previous
        </Button>

        {generatePageNumbers().map((page, index) => (
          <Button
            key={index}
            onClick={() => typeof page === "number" && onPageChange(page)}
            isDisabled={typeof page !== "number"}
            variant={page === currentPage ? "solid" : "outline"}
            colorScheme={page === currentPage ? "blue" : "gray"}
          >
            {page}
          </Button>
        ))}

        <Button 
          onClick={() => onPageChange(currentPage + 1)} 
          isDisabled={currentPage >= totalPages}
        >
          Next
        </Button>
      </ButtonGroup>
    </Flex>
  );
};

export default Pagination;
