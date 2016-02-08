json.array!(@todos) do |todo|
  json.extract! todo, :id, :title, :isCompleted
  json.url todo_url(todo, format: :json)
end
