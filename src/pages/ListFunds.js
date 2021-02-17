import React from 'react';
import { useQuery } from 'graphql-hooks';
import styled from 'styled-components';

const Container = styled.div`
  display: flex;
  color: black;
`;

const ListFunds = () => {
  const GRAPH_QUERY = `query {
    allFunds(page: 0, size: 10) {
        id
        name
    }
    }
    
    `;
  const { data } = useQuery(GRAPH_QUERY);

  return (
    <Container>
      {data && data.allFunds.map((x) => <div> {x.name} </div>)}
    </Container>
  );
};

export { ListFunds };
