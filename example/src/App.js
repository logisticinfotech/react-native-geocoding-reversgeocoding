// import * as React from 'react';

// import { StyleSheet, View, Text } from 'react-native';
// import { multiply } from 'react-native-my-location-app';

// export default function App() {
//   const [result, setResult] = React.useState<number | undefined>();

//   React.useEffect(() => {
//     multiply(3, 7).then(setResult);
//   }, []);

//   return (
//     <View style={styles.container}>
//       <Text>Result: {result}</Text>
//     </View>
//   );
// }

// const styles = StyleSheet.create({
//   container: {
//     flex: 1,
//     alignItems: 'center',
//     justifyContent: 'center',
//   },
//   box: {
//     width: 60,
//     height: 60,
//     marginVertical: 20,
//   },
// });


/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

 import React from 'react';
 import {
   SafeAreaView,
   ScrollView,
   StatusBar,
   StyleSheet,
   Text,
   useColorScheme,
   View,
 } from 'react-native';
 
 import {
   Colors,
   DebugInstructions,
   Header,
 } from 'react-native/Libraries/NewAppScreen';
 import Home from './Home';
 
 const App = () => {
   const isDarkMode = useColorScheme() === 'dark';
 
   const backgroundStyle = {
     // backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
     backgroundColor: Colors.lighter,
   };
 
   return (
     <SafeAreaView style={backgroundStyle}>
       <StatusBar barStyle={'light-content'} />
       {/* <StatusBar barStyle={isDarkMode ? 'light-content' : 'dark-content'} /> */}
       <Home />
       {/* <ScrollView
         contentInsetAdjustmentBehavior="automatic"
         style={backgroundStyle}>
         <Header />
         <View
           style={{
             // backgroundColor: Colors.white,
             backgroundColor: isDarkMode ? Colors.black : Colors.white,
           }}>
           <Home />
         </View>
       </ScrollView> */}
     </SafeAreaView>
   );
 };
 
 const styles = StyleSheet.create({
   sectionContainer: {
     marginTop: 32,
     paddingHorizontal: 24,
   },
   sectionTitle: {
     fontSize: 24,
     fontWeight: '600',
   },
   sectionDescription: {
     marginTop: 8,
     fontSize: 18,
     fontWeight: '400',
   },
   highlight: {
     fontWeight: '700',
   },
 });
 
 export default App;
 