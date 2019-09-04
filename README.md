# Asynchronous Programming Recipebook: RxJava and Kotlin

This project contains sample code written to compare the capabilities of RxJava 3 and Kotlin's native Asynchronous programming toolset (coroutines, channels, flows). 
The intention is to provide a reference for developers who may be familiar with one of the systems and in the process of learning the other.
The samples are intended to be similar across systems, although in some cases they do diverge somewhat to demonstrate a best-practice that may be unique to the different APIs. Each folder also contains a _Test_ file for the implementations within. 
These tests are not true unit tests, since they're not automatically verifying behavior; instead they are intended to be executed by interested developers and modified as needed for experimentation.

## Contributing
Contributions, corrections, and suggestions to this repository are welcome. 
If you find an error in a sample please open an issue. 
PRs adding additional samples should contain a version using RxJava 3, a version demonstrating Kotlin's asynchronous APIs, and a file setting up a test execution of each system.

## License

```
Copyright 2019 Pandora Media, LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
See accompanying LICENSE file or you may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
