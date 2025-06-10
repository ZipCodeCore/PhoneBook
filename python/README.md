# Python PhoneBook Lab

This is the Python version of the PhoneBook lab for beginner coders.

## Getting Started

### Prerequisites
- Python 3.7 or higher

### Running Tests

To run all tests:
```bash
python -m unittest discover -s . -p "test_*.py"
```

To run a specific test file:
```bash
python -m unittest test_constructor.py
```

### Implementation Tasks

Students need to implement the following methods in `phonebook.py`:

1. `__init__()` - Constructor that initializes the phonebook dictionary
2. `add()` - Add a phone number for a contact
3. `add_all()` - Add multiple phone numbers for a contact
4. `remove()` - Remove a contact from the phonebook
5. `has_entry()` - Check if a contact exists (with optional phone number check)
6. `lookup()` - Look up all phone numbers for a contact
7. `reverse_lookup()` - Find the contact name for a given phone number
8. `get_all_contact_names()` - Get all contact names in the phonebook
9. `get_map()` - Get the underlying dictionary representation

### Test Files

- `test_constructor.py` - Tests for constructor functionality
- `test_add_all.py` - Tests for adding multiple phone numbers
- `test_get_all_contact_names.py` - Tests for retrieving all contact names
- `test_remove.py` - Tests for removing contacts
- `test_reverse_lookup.py` - Tests for reverse phone number lookup

### Data Structure

The phonebook uses a dictionary where:
- Keys are contact names (strings)
- Values are lists of phone numbers (List[str])

Example:
```python
{
    "John": ["302-555-1234", "302-555-5678"],
    "Jane": ["302-555-9999"]
}
```