def lala(names)
    if names.respond_to?("each")
        names.each do |name|
            puts "#{name}"
        end
    else
        puts "err"
    end
end

a = ["mumu","momo","papa"]
a = "popo"
lala(a)

