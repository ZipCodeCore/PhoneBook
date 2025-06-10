import unittest
from phonebook import PhoneBook


class TestGetAllContactNames(unittest.TestCase):

    def test_get_all_contact_names_1(self):
        # given
        phone_book = PhoneBook()
        names = ["John", "Joe", "Jim", "Jay"]
        for name in names:
            phone_book.add(name, "")

        # when
        actual_names = phone_book.get_all_contact_names()

        # then
        self.assertEqual(names, actual_names)

    def test_get_all_contact_names_2(self):
        # given
        phone_book = PhoneBook()
        names = ["Chris", "Christian", "Christopher", "Christina"]
        for name in names:
            phone_book.add(name, "")

        # when
        actual_names = phone_book.get_all_contact_names()

        # then
        self.assertEqual(names, actual_names)

    def test_get_all_contact_names_3(self):
        # given
        phone_book = PhoneBook()
        names = ["Ashley", "Aaron", "Albert", "Alfred"]
        for name in names:
            phone_book.add(name, "")

        # when
        actual_names = phone_book.get_all_contact_names()

        # then
        self.assertEqual(names, actual_names)


if __name__ == '__main__':
    unittest.main()