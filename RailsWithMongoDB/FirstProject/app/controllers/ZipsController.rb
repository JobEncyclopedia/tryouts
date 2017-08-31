class ZipsController < ApplicationController
  before_action :set_zip, only: [:show, :edit, :update, :destroy]

  # GET /zips
  # GET /zips.json
  def index
    #@zips = Zip.all
    #@zips = Zip.paginate(params)

    args=params.clone                      #update a clone of params
    args[:sort]=get_sort_hash(args[:sort]) #replace sort with hash
    @zips = Zip.paginate(args)
  end
end