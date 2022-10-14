import { createDrawerNavigator } from "@react-navigation/drawer";
import { NavigationContainer } from "@react-navigation/native";
import React from "react";
import "react-native-gesture-handler";
import Main from "./src/components/Main";
import Acerca from "./src/Pages/Acerca";
import Contacto from "./src/Pages/Contacto";
import inicio from "./src/Pages/inicio";

const Menu = createDrawerNavigator();
export default function App() {
  return (
    <NavigationContainer>
      <Menu.Navigator>
        <Menu.Screen name="Inicio" component={inicio} />
        <Menu.Screen name="Contacto" component={Contacto} />
        <Menu.Screen name="Acerca" component={Acerca} />
      </Menu.Navigator>
    </NavigationContainer>
  );
}
