class Solution {
public:
    int reverse(int x) {
        string number = std::to_string(x);
        string reversedNumber = number;
        for(int i = 0; i < number.size(); i++){
            reversedNumber[reversedNumber.size()-1-i] = number[i];
        }
        if(x < 0) {
            long long int test = std::stoll(reversedNumber) * -1;
            if(test < -2147483648)
                return 0;
            return static_cast<int>(test);
        } else{
            long long int test = std::stoll(reversedNumber);
            if(test > 2147483647)
                return 0;
            return static_cast<int>(test);
        }
    }
};