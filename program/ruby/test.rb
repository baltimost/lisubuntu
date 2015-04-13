class Greeter
    def initialize(name = "world")
        @name = name
    end

    def say_hi
        puts "hello #{@name}"
    end

    def say_bye
        puts "bye #{@name}"
    end
end


if __FILE__ == $0
    g = Greeter.new
    g.say_hi
    g.say_bye

    g2 = Greeter.new("matz")
    g2.say_hi
    g2.say_bye

    puts g2.@name
end

