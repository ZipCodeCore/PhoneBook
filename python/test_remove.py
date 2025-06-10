import unittest
from phonebook import PhoneBook


class TestRemove(unittest.TestCase):

    def test_remove_1(self):
        # given
        phone_book = PhoneBook()
        name = "John"
        phone_number = "302-555-4545"
        phone_book.add(name, phone_number)
        self.assertTrue(phone_book.has_entry(name, phone_number))

        # when
        phone_book.remove(name)

        # then
        self.assertFalse(phone_book.has_entry(name))

    def test_remove_2(self):
        # given
        phone_book = PhoneBook()
        name = "Joe"
        phone_number = "302-554-4545"
        phone_book.add(name, phone_number)
        self.assertTrue(phone_book.has_entry(name, phone_number))

        # when
        phone_book.remove(name)

        # then
        self.assertFalse(phone_book.has_entry(name))

    def test_remove_3(self):
        # given
        phone_book = PhoneBook()
        name = "Smith"
        phone_number = "302-554-4535"
        phone_book.add(name, phone_number)
        self.assertTrue(phone_book.has_entry(name, phone_number))

        # when
        phone_book.remove(name)

        # then
        self.assertFalse(phone_book.has_entry(name))


if __name__ == '__main__':
    unittest.main()