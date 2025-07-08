
import os
from cryptography.fernet import Fernet

class SecureKeyOps:
    def __init__(self, key=None):
        self.key = key or Fernet.generate_key()
        self.fernet = Fernet(self.key)

    def encrypt(self, data: str) -> str:
        return self.fernet.encrypt(data.encode()).decode()

    def decrypt(self, token: str) -> str:
        return self.fernet.decrypt(token.encode()).decode()
