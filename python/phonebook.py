from typing import Dict, List, Optional


class PhoneBook:
    """
    Created by leon on 1/23/18.
    Made WAY better by kristofer 6/16/20
    Python version for beginner coders
    """

    def __init__(self, phonebook_dict: Optional[Dict[str, List[str]]] = None):
        """
        Constructor for PhoneBook
        :param phonebook_dict: Optional dictionary to initialize the phonebook with
        """
        self.phonebook = None

    def add(self, name: str, phone_number: str) -> None:
        """
        Add a phone number for a contact
        :param name: Contact name
        :param phone_number: Phone number to add
        """
        pass

    def add_all(self, name: str, *phone_numbers: str) -> None:
        """
        Add multiple phone numbers for a contact
        :param name: Contact name
        :param phone_numbers: Variable number of phone numbers to add
        """
        pass

    def remove(self, name: str) -> None:
        """
        Remove a contact from the phonebook
        :param name: Contact name to remove
        """
        pass

    def has_entry(self, name: str, phone_number: str = None) -> bool:
        """
        Check if a contact exists, optionally with a specific phone number
        :param name: Contact name to check
        :param phone_number: Optional phone number to check
        :return: True if contact exists (with phone number if specified), False otherwise
        """
        return None

    def lookup(self, name: str) -> List[str]:
        """
        Look up all phone numbers for a contact
        :param name: Contact name to look up
        :return: List of phone numbers for the contact
        """
        return None

    def reverse_lookup(self, phone_number: str) -> str:
        """
        Find the contact name for a given phone number
        :param phone_number: Phone number to look up
        :return: Contact name associated with the phone number
        """
        return None

    def get_all_contact_names(self) -> List[str]:
        """
        Get all contact names in the phonebook
        :return: List of all contact names
        """
        return None

    def get_map(self) -> Dict[str, List[str]]:
        """
        Get the underlying dictionary representation of the phonebook
        :return: Dictionary mapping names to lists of phone numbers
        """
        return None