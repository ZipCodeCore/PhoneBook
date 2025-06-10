import unittest
from phonebook import PhoneBook


class TestConstructor(unittest.TestCase):

    def test_nullary_constructor(self):
        # given
        # when
        phone_book = PhoneBook()

        # then
        self.assertIsInstance(phone_book.get_map(), dict)

    def test_non_nullary_constructor(self):
        # given
        dependency = {}

        # when
        phone_book = PhoneBook(dependency)

        # then
        self.assertEqual(dependency, phone_book.get_map())


if __name__ == '__main__':
    unittest.main()