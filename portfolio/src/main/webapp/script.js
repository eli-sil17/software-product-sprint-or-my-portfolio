// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Thats what she said', 'beats, bear, battlestar galactica', 'identity theft is not a joke jim', 'Boy, have you done lost your mind? Cause I’ll help you find it!', 'The worst thing about prison was the dementors.'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

async function greeting() {
    const responseFromServer = await fetch('/hello');
    const textFromResponse = await responseFromServer.json();
  
    const dateContainer = document.getElementById('greet-ely');
    const rand = textFromResponse[Math.floor(Math.random() * textFromResponse.length)];
    dateContainer.innerText =rand;
    
    
   
    console.log(textFromResponse[0].fact);
    console.log(textFromResponse);
    //console.log(textFromResponse.z);
  }
