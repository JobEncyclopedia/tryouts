class ApplicationController < ActionController::Base
  protect_from_forgery with: :null_session

  def hello
    render html: "hello, world!"
  end
  
  # POST /zips
  # POST /zips.json
  def create
    @sample = Sample.new(sample_params)

    respond_to do |format|
      if @sample.save
        format.html { redirect_to @sample, notice: 'Sample was successfully created.' }
        format.json { render :show, status: :created, location: @sample }
      else
        format.html { render :new }
        format.json { render json: @sample.errors, status: :unprocessable_entity }
      end
    end
  end
  private
  def sample_params
    params.permit(:job_name, :job_desc, :field, :avg_salary)
  end
end