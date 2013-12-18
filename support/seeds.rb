# This file is used to seed data using mongo db restore

def db_copy_load_config
  if ENV['USE_RAILS']
    YAML.load(ERB.new(File.read(Rails.root.join("config/mongoid.yml"))).result).symbolize_keys
  else
    YAML.load(ERB.new(File.read("config/mongoid.yml")).result).symbolize_keys
  end
end
    
def db_copy_config
  @@config_mongoid ||= db_copy_load_config
end

def parse_mongodb_url(url)
  uri = URI.parse(url)
  database_name = uri.path.gsub("/", "")
  return uri, database_name
end

def parse_mongodb_data
   db_uri = @@config_mongoid[:test]['uri']
   if !db_uri.blank?
        to, to_db_name = parse_mongodb_url(db_uri)
        return to.host, to.port, to.user, to.password, to_db_name
   else        
        return @@config_mongoid[:test]['host'], @@config_mongoid[:test]['port'], '', '', @@config_mongoid[:test]['database']
    end    
end

def get_dump_data_dir
    if ENV['USE_RAILS']
        "#{Rails.root}/blackbox/data/vestorly-test"   
    else
        "data/vestorly-test"   
    end
end

db_copy_config
puts @@config_mongoid

db_name_dir = get_dump_data_dir
to_host, to_port, to_user, to_password, to_db_name = parse_mongodb_data

if !to_user.blank?
    mongo_restore_command = "mongorestore -h %s --port %s --drop -d %s -u %s -p %s %s" % [ to_host, to_port, 
        to_db_name, to_user, to_password, db_name_dir ]
else
    mongo_restore_command = "mongorestore -h %s --port %s --drop -d %s %s" % [ to_host, to_port, 
        to_db_name, db_name_dir ]
end    

puts mongo_restore_command

output=`#{mongo_restore_command}` ;  result=$?.success?

puts output

if !result
    raise "Unable to restore mongo DB data"
end
