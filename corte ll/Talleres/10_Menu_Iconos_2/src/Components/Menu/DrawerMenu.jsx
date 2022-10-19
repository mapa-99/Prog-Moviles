import { View, Text } from "react-native";
import React from "react";
import { TouchableOpacity } from "react-native-gesture-handler";
import { Icon } from "react-native-vector-icons/FontAwesome";


import s from "../../styles/style";

const DrawerMenu = ({ iconName, titleName, navigation }) => {
  return (
    <TouchableOpacity onPress={navigation}>
      <View style={s.menuContainer}>
        <View style={s.iconoContainer}>
          <Icon size={17} name={iconName} />
        </View>
        <View style={s.tituloContainer}>
          <Text style={s.tituloTxt}>{titleName}</Text>
        </View>
      </View>
    </TouchableOpacity>
  );
};

export default DrawerMenu;
