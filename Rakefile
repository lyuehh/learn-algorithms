task :run do
  file = ENV["file"] || ENV["f"]
  raise "no file given" unless file
  f = './src/' + file + '.c'
  raise "no src/#{file} found" unless File.exist?(f)
  system "gcc #{f}"
  #exec = "src/#{file.split('/')[0]}/a.out"
  system "./a.out"
  system "rm a.out"
end
