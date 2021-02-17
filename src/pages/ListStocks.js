import React from 'react';
import { useQuery } from 'graphql-hooks';
import styled from 'styled-components';

const Container = styled.div`
  display: flex;
  color: black;
`;

const ListStocks = ({ fundId }) => {
  console.log(fundId);
  const GRAPH_QUERY = `query($fundId: Int) {
    fundById(id:$fundId) {
      stocks {
        stock {
          name
        }
      }
    }
  }
    `;
  const { data } = useQuery(GRAPH_QUERY, {
    variables: { fundId },
  });
  console.log(data);
  return (
    <Container>
      <ul>
        {data && data.fundById.stocks.map((x) => <li> {x.stock.name} </li>)}
      </ul>
    </Container>
  );
};

export { ListStocks };
