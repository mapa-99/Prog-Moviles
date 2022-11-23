import {View,  StyleSheet} from 'react-native';
import React from 'react';
import MusicPlayer from './src/Pages/MusicPlayer';


const App = () => {
  return (
    <View style={style.container}>
      <MusicPlayer />
    </View>
  );
};

export default App;
const style = StyleSheet.create({container: {flex: 1}});
