import { StyleSheet, Text, View } from "react-native";
import React from "react";

const Acerca = () => {
  return (
    <View style={styles.container}>
      <Text>Pantalla 3</Text>
      <Text>Acerca</Text>
    </View>
  );
};

export default Acerca;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
