import React, { createContext, useContext, useState } from "react";

// Create a new context
const SubContext = createContext();

// Create a provider component
export const SubContextProvider = ({ children }) => {
  const [subState, setSubState] = useState([]);
  const [stroski, setStroski] = useState(22);

  return (
    <SubContext.Provider value={{ subState, setSubState, stroski, setStroski }}>
      {children}
    </SubContext.Provider>
  );
};

// Custom hook to consume the context
export const useSubContext = () => {
  return useContext(SubContext);
};
