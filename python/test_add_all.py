import unittest
from phonebook import PhoneBook


class TestAddAll(unittest.TestCase):

    def test_add_all_1(self):
        # given
        phone_book = PhoneBook()
        name = "Joe"
        phone_numbers = [
            "302-555-4444",
            "302-555-3333",
            "302-555-2222",
            "302-555-1111",
        ]

        # when
        phone_book.add_all(name, *phone_numbers)
        actual_phone_numbers = phone_book.lookup(name)
        
        # then
        self.assertEqual(phone_numbers, actual_phone_numbers)

    def test_add_all_2(self):
        # given
        phone_book = PhoneBook()
        name = "Joe"
        phone_numbers = [
            "302-555-5555",
            "302-555-4444",
            "302-555-3333",
            "302-555-2222",
        ]

        # when
        phone_book.add_all(name, *phone_numbers)
        actual_phone_numbers = phone_book.lookup(name)
        
        # then
        self.assertEqual(phone_numbers, actual_phone_numbers)

    def test_add_all_3(self):
        # given
        phone_book = PhoneBook()
        name = "Joe"
        phone_numbers = [
            "302-555-1212",
            "302-555-3434",
            "302-555-4545",
            "302-555-5656",
        ]

        # when
        phone_book.add_all(name, *phone_numbers)
        actual_phone_numbers = phone_book.lookup(name)
        
        # then
        self.assertEqual(phone_numbers, actual_phone_numbers)


if __name__ == '__main__':
    unittest.main()