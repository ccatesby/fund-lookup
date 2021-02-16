import React from 'react';
import styled from 'styled-components';
import type { Node } from 'react';

const Container = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  box-sizing: border-box;
  color: white;
  height: 100%;
  font-size: 1.2em;
  width: 100%;
`;

const Body = styled.div`
  display: flex;
  flex-direction: column;
  flex: none;
`;

const Main = styled.main`
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 100%;
`;

const Layout = ({ children }: { children: Node }) => {
  return (
    <Container>
      <Body>
        <Main>{children}</Main>
      </Body>
    </Container>
  );
};

export { Layout };
