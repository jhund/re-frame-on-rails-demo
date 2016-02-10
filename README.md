# re-frame-on-rails-demo

## Installation

* clone repo
* cd into `<Rails ROOT>`
* rake db:migrate
* rails s
* create some sample todos using curl:
    curl -H "Content-Type:application/json; charset=utf-8" -d '{"todo": {"title":"Todo 1","isCompleted":false}}' http://localhost:3000/todos.json
    curl -H "Content-Type:application/json; charset=utf-8" -d '{"todo": {"title":"Todo 2","isCompleted":false}}' http://localhost:3000/todos.json

## Usage

### Start Rails app

* open console #1
* cd into `<Rails ROOT>`
* rails s

### Start cljs app

* open console #2
* cd into `<Rails ROOT>/todomvc`
* `lein do clean, figwheel`
* open `http://localhost:3450` in browser

## Resources

* Very good info: https://www.reddit.com/r/Clojure/comments/3n1vxk/question_what_is_the_best_way_to_organize_cljs/
* One way to organize files: https://corbt.com/posts/2015/03/16/clojurescript-in-rails.html
* Seems a bit odd: http://public-action.org/content/polyglot-leveraging-ruby-rails-and-clojurescript
* How to use Rails as API backend: https://wyeworks.com/blog/2015/6/30/how-to-build-a-rails-5-api-only-and-ember-application

* https://github.com/jteneycke/rails-boot-reagent
