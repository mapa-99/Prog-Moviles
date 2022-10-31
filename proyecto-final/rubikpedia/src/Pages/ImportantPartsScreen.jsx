import {View, Text} from 'react-native';
import React from 'react';
import PartsCard from '../Components/PartsCard';
import {partes} from '../partes';
const ImportantPartsScreen = () => {
  return (
    <View style={{justifyContent: 'center', alignItems: 'center'}}>
      <Text>Partes importantes de un cubo de Rubik</Text>
      {partes.map(part => (
        <PartsCard
          title={part.title}
          img={part.img}
          description={part.description}
        />
      ))}
    </View>
  );
};

export default ImportantPartsScreen;
