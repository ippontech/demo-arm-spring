# ARM demo app

Sends back som possibly CPU-specific info.

## Building on Github

As a hack and since I don't know Best Practices ™️   for Github Actions,
this:

1. Runs test steps first on PR
2. If merged, tests, builds and shoves the JAR into docker containers and pushes them
