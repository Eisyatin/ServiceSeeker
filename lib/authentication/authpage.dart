import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:bookingreal/authentication/loginpage.dart';
import 'package:bookingreal/homepage.dart';
import 'package:bookingreal/authentication/loginorregister.dart';
import '../address.dart';

//check the user has sign in or not
class AuthPage extends StatelessWidget {
  const AuthPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: StreamBuilder<User?>(
        stream: FirebaseAuth.instance
            .authStateChanges(), //if the user is logged in or not
        builder: (context, snapshot) {
          //user is logged in
          if (snapshot.hasData) {
            return AddressMapScreen();
          }

          //user is not logged in
          else {
            return LoginOrRegsterPage();
          }
        },
      ),
    );
  }
}
