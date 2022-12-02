import {
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
  SafeAreaView,
  Dimensions,
  Image,
} from 'react-native';
import React, {useEffect} from 'react';
import Ionicons from 'react-native-vector-icons/Ionicons';
import image from '../../assets/imgs/cover.jpg';
import Slider from '@react-native-community/slider';
import track from '../../assets/songs/track.mp3';

import Sound from 'react-native-sound';
const {width, height} = Dimensions.get('window');

const MusicPlayer = () => {
  Sound.setCategory('Playback');
  var ding = new Sound(track, Sound.MAIN_BUNDLE, error => {
    if (error) {
      console.log('failed to load the sound', error);
      return;
    }

    // when loaded successfully
    console.log(
      'duration in seconds: ' +
        whoosh.getDuration() +
        'number of channels: ' +
        whoosh.getNumberOfChannels(),
    );
  });
  useEffect(() => {}, []);

  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.main}>
        <View style={[styles.img, styles.elevation]}>
          <Image source={image} style={styles.musicImg} />
        </View>

        <View>
          <Text style={styles.title}> Safe and Sound</Text>
          <Text style={styles.artist}> Capital Cities</Text>
        </View>
        <View>
          <Slider
            style={styles.progressBar}
            value={10}
            minimumValue={0}
            maximumValue={100}
            thumbTintColor="#ffd369"
            minimumTrackTintColor="#ffd369"
            maximumTrackTintColor="#fff"
            onSlidingComplete={() => {}}
          />
          <View style={styles.duration}>
            <Text style={styles.durationText}>00:00</Text>
            <Text style={styles.durationText}>00:00</Text>
          </View>
        </View>
        <View style={styles.controls}>
          <TouchableOpacity onPress={() => {}}>
            <Ionicons name="play-skip-back-outline" size={35} color="#ffd369" />
          </TouchableOpacity>
          <TouchableOpacity
            onPress={() => (ding.isPlaying() ? ding.pause() : ding.play())}>
            <Ionicons
              name={ding.isPlaying() ? 'ios-pause-circle' : 'ios-play-circle'}
              size={75}
              color="#ffd369"
            />
          </TouchableOpacity>
          <TouchableOpacity onPress={() => {}}>
            <Ionicons
              name="play-skip-forward-outline"
              size={35}
              color="#ffd369"
            />
          </TouchableOpacity>
        </View>
      </View>

      <View style={styles.bottom}>
        <View style={styles.icons}>
          <TouchableOpacity onPress={() => {}}>
            <Ionicons name="heart-outline" size={30} color="#888888" />
          </TouchableOpacity>
          <TouchableOpacity onPress={() => {}}>
            <Ionicons name="repeat" size={30} color="#888888" />
          </TouchableOpacity>
          <TouchableOpacity onPress={() => {}}>
            <Ionicons name="share-outline" size={30} color="#888888" />
          </TouchableOpacity>
          <TouchableOpacity onPress={() => {}}>
            <Ionicons name="ellipsis-horizontal" size={30} color="#888888" />
          </TouchableOpacity>
        </View>
      </View>
    </SafeAreaView>
  );
};

export default MusicPlayer;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#222831',
  },
  main: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  bottom: {
    width: width,
    alignItems: 'center',
    paddingVertical: 15,
    borderTopColor: '#393e46',
    borderWidth: 1,
  },
  icons: {flexDirection: 'row', justifyContent: 'space-between', width: '80%'},
  img: {width: 300, height: 320, marginBottom: 25},
  musicImg: {
    width: '100%',
    height: '100%',
    borderRadius: 15,
  },
  elevation: {
    elevation: 5,
    shadowColor: '#ccc',
    shadowOffset: {
      width: 5,
      height: 5,
    },
    shadowOpacity: 0.5,
    shadowRadius: 3.84,
  },
  title: {
    fontSize: 18,
    fontWeight: '600',
    textAlign: 'center',
    color: '#EEEEEE',
  },
  artist: {
    fontSize: 16,
    fontWeight: '300',
    textAlign: 'center',
    color: '#EEEEEE',
  },
  progressBar: {
    width: 350,
    height: 40,
    marginTop: 25,
    flexDirection: 'row',
  },
  duration: {
    width: 340,
    flexDirection: 'row',
    justifyContent: 'space-between',
  },
  durationText: {color: '#fff', fontWeight: '50'},
  controls: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    width: '60%',
    marginTop: 15,
  },
});
