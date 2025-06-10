#include <cstdint>
#include <iostream>
#include <string>

using namespace std;

int main()
{
	string encrypted;

	cout << "Enter encrypted string (NO NEWLINES): ";
	getline(cin, encrypted);

	char* str = (char*)encrypted.c_str();
	uint64_t size = (uint64_t)encrypted.size();

	int64_t last_code = -1i64;

	for (uint64_t i = 0ui64; i < size; ++i)
	{
		bool upper_case = false;
		char symbol = str[i];

		if (symbol >= 'A' && symbol <= 'Z')
		{
			symbol += 'a' - 'A';
			upper_case = true;
		}

		if (symbol >= 'a' && symbol <= 'z')
		{
			int64_t code = (int64_t)(symbol - 'a');
			int64_t _last_code = code;

			if (last_code != -1i64)
			{
				code -= last_code;

				if (code < 0i64)
					code += 26i64;

				symbol = (char)code + 'a';

				if (upper_case)
					symbol -= 'a' - 'A';

				str[i] = symbol;
			}

			last_code = _last_code;
		}
	}

	cout << "Decrypted string: " << encrypted << endl;
	cin >> last_code;
}