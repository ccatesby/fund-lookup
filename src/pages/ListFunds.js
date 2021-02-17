import React from 'react';
import { useQuery } from 'graphql-hooks';
import styled from 'styled-components';
import { navigate } from '@reach/router';

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
      <ul>
        {data &&
          data.allFunds.map((x) => (
            <li onClick={() => navigate(`/stocks/${x.id}`)}> {x.name} </li>
          ))}
      </ul>
    </Container>
  );
};

export { ListFunds };
