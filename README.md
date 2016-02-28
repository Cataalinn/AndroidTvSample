# AndroidTvSample
Android Tv and Mobile

Implementing Rotten Tomatoes API in order to get movies for mobile and TV using Dagger2 for injection, RxJava and Retrofit to provide movies.

Implementing Vine-App API in order to get vines for mobile and TV using Dagger2 for injection, RxJava and Retrofit to provide movies.

For both apis i created 2 different modules who contains backend. Them are created using MVP Framework using Retrofit for calls and RxJava to propagate events starting from model to delegate(implemented by fragments).

Mobile and Tv sides have Dagger2 implementations to instantiate Models, Presenters and what they need.

For now,  mobile side is working. Videos are played into a SurfaceView for better rendering.
Tv side is on hold because AndroidTv emulator internet is not working and i don't have an AndroidTv. Waiting for one of this.

@UnderDevelopment
