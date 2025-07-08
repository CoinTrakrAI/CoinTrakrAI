
from ui.mode_toggle import get_user_mode

def get_dashboard_layout(user_prefs):
    mode = get_user_mode(user_prefs)
    if mode == "beginner":
        return "ui/layouts/beginner_dashboard.xml"
    elif mode == "intermediate":
        return "ui/layouts/intermediate_dashboard.xml"
    return "ui/layouts/expert_dashboard.xml"
