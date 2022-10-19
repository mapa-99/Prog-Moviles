import { View, Text } from "react-native";
import React from "react";
import s from "../../styles/style";
import DrawerMenu from "./DrawerMenu";

const Menu = ({ navigation }) => {
  return (
    <View style={s.container}>
      <DrawerMenu
        iconName="home"
        titleName="Home"
        navigation={() => navigation.navigate("Home")}
      />
      <DrawerMenu
        iconName="user"
        titleName="Profile"
        navigation={() => navigation.navigate("Profile")}
      />
      <DrawerMenu
        iconName="bell"
        titleName="Notification"
        navigation={() => navigation.navigate("Notification")}
      />
    </View>
  );
};

export default Menu;
