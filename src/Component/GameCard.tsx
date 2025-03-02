import { Button, Card, CardBody, CardFooter, Heading, Image, Stack, Text } from '@chakra-ui/react'
import React, { Component } from 'react'

interface GameCardProps {
  title: string;
  imageUrl: string;
}

export class GameCard extends Component<GameCardProps> {
  render() {
    const { title, imageUrl } = this.props;
    
    return (
      <div>
        <Card direction={{ base: 'column', sm: 'row' }} overflow='hidden' variant='outline'>
          <Image 
            objectFit='cover' 
            maxW={{ base: '100%', sm: '200px' }} 
            src={imageUrl} 
            alt={title} 
            fallbackSrc="https://via.placeholder.com/200x300?text=No+Image"
          />
          <Stack>
            <CardBody>
              <Heading size='md'>{title}</Heading>
              <Text py='2'>
                A popular video game from the RAWG database.
              </Text>
            </CardBody>
            <CardFooter>
              <Button variant='solid' colorScheme='blue'>
                View Details
              </Button>
            </CardFooter>
          </Stack>
        </Card>
      </div>
    )
  }
}

export default GameCard