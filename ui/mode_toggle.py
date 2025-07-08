
def get_user_mode(user_prefs):
    if user_prefs.get("mode") == "expert":
        return "expert"
    if user_prefs.get("mode") == "intermediate":
        return "intermediate"
    return "beginner"
