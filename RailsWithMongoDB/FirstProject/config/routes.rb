Rails.application.routes.draw do
  root 'application#hello'
  post 'create' => 'application#create'
end