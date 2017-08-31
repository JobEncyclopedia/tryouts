class SampleCollection
  include Mongoid::Document
  store_in collection: "SampleCollection", database: "SampleDatabase", client: "secondary"
end