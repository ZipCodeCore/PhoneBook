import unittest
from phonebook import PhoneBook


class TestReverseLookup(unittest.TestCase):

    def test_reverse_lookup_1(self):
        # given
        phone_book = PhoneBook()
        expected_name = "John"
        phone_number = "302-555-4545"
        phone_book.add(expected_name, phone_number)
        self.assertTrue(phone_book.has_entry(expected_name, phone_number))

        # when
        actual_name = phone_book.reverse_lookup(phone_number)

        # then
        self.assertEqual(expected_name, actual_name)

    def test_reverse_lookup_2(self):
        # given
        phone_book = PhoneBook()
        expected_name = "Joe"
        phone_number = "302-554-4545"
        phone_book.add(expected_name, phone_number)
        self.assertTrue(phone_book.has_entry(expected_name, phone_number))

        # when
        actual_name = phone_book.reverse_lookup(phone_number)

        # then
        self.assertEqual(expected_name, actual_name)

    def test_reverse_lookup_3(self):
        # given
        phone_book = PhoneBook()
        expected_name = "Smith"
        phone_number = "302-554-4535"
        phone_book.add(expected_name, phone_number)
        self.assertTrue(phone_book.has_entry(expected_name, phone_number))

        # when
        actual_name = phone_book.reverse_lookup(phone_number)

        # then
        self.assertEqual(expected_name, actual_name)


if __name__ == '__main__':
    unittest.main()