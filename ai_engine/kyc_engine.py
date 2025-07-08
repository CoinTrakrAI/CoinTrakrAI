
class KYCComplianceRouter:
    def __init__(self):
        self.kyc_required_regions = ['US', 'UK', 'EU']
        self.restricted_regions = ['CN', 'RU']

    def evaluate_user(self, user_region):
        if user_region in self.restricted_regions:
            return 'block'
        elif user_region in self.kyc_required_regions:
            return 'require_kyc'
        else:
            return 'allow'
