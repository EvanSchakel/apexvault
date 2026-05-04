#!/usr/bin/env bash
set -euo pipefail

# Helper to create a GitHub repository and push the current directory.
# Requires: `gh` (GitHub CLI) authenticated as a user with repo creation rights.

REPO_NAME="apexvault"
DESCRIPTION="Terminal-first personal finance manager in Java"

if ! command -v gh >/dev/null 2>&1; then
  echo "gh CLI not found. Install from https://cli.github.com/ and authenticate (gh auth login)."
  exit 2
fi

echo "Creating GitHub repository: ${REPO_NAME} (public)"
gh repo create "${REPO_NAME}" --public --source=. --push --description "${DESCRIPTION}" --confirm

echo "Repository created and pushed."
