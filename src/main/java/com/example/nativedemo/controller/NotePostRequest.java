package com.example.nativedemo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

record NotePostRequest(@JsonProperty("content") String content) {

}
