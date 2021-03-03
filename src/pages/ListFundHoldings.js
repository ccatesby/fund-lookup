import React from 'react';
import { useQuery } from 'graphql-hooks';
import styled from 'styled-components';

const Container = styled.div`
  display: flex;
  color: black;
`;

const ListFundHoldings = ({ fundId }) => {
  const GRAPH_QUERY = `query($fundId: Int) {
    funds(filter:{id: $fundId, holding_and: {isCurrent: true}}) {
      name
      stocks {
        id,
        stock {
          name
        }
        price
        shares
      }
    }
  }
    `;
  const { data } = useQuery(GRAPH_QUERY, {
    variables: { fundId },
  });

  return (
    <Container>
      <ul>
        {data && data.funds[0].stocks.map((x) => <li> {x.stock.name} </li>)}
      </ul>
    </Container>
  );
};

export { ListFundHoldings };
