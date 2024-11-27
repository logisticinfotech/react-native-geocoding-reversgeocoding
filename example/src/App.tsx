import { useState, useEffect } from 'react';
import { StyleSheet, SafeAreaView, StatusBar, useColorScheme } from 'react-native';
import Home from './Home'

const App = () => {
  return (
    <SafeAreaView >
      <StatusBar barStyle={'light-content'} />
      <Home />
    </SafeAreaView>
  );
}

export default App;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
