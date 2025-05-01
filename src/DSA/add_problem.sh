#!/bin/bash

# Usage:
# ./add_problem.sh "https://leetcode.com/problems/two-sum/" e "Array, HashMap"
# ./add_problem.sh "https://leetcode.com/problems/two-sum/" m

PROBLEM_LINK=$1
INPUT_DIFFICULTY=$(echo "$2" | tr '[:upper:]' '[:lower:]')
TAGS=$3

if [ -z "$PROBLEM_LINK" ]; then
  echo "❌ Usage: ./add_problem.sh <leetcode-url> [e|m|h] [tags]"
  exit 1
fi

# Normalize difficulty
case "$INPUT_DIFFICULTY" in
  e) DIFFICULTY="Easy" ;;
  m) DIFFICULTY="Medium" ;;
  h) DIFFICULTY="Hard" ;;
  *) DIFFICULTY="Default" ;;
esac

# Extract problem slug from the URL (e.g., maximum-points-you-can-obtain-from-cards)
SLUG=$(echo "$PROBLEM_LINK" | awk -F/ '{print $(NF-2)}')

# Convert the slug to CamelCase for class name and filename
CLASS_NAME=$(echo "$SLUG" | sed -E 's/[-]/ /g' | awk '{for(i=1;i<=NF;i++) $i=toupper(substr($i,1,1)) substr($i,2)}1' | tr -d ' ')
FILE_NAME="${CLASS_NAME}.java"

# Convert slug to readable problem title (optional)
PROBLEM_NAME=$(echo "$SLUG" | sed -E 's/-/ /g' | awk '{for(i=1;i<=NF;i++) $i=toupper(substr($i,1,1)) substr($i,2)}1')

# Determine category and folder (using the last part of the current folder if no tags provided)
if [ -n "$TAGS" ]; then
  CATEGORY=$(echo "$TAGS" | cut -d',' -f1 | tr -d ' ' | tr '[:upper:]' '[:lower:]')
else
  CATEGORY=$(basename "$PWD")  # If no category is provided, use the current folder name
fi

# Create the folder if needed and set the file path
mkdir -p "$CATEGORY"
FILEPATH="$CATEGORY/$FILE_NAME"

# Create the Java file with the problem information (no package declaration)
cat << EOF > "$FILEPATH"
/**
 * Problem: $PROBLEM_NAME
 * Link: <a href="$PROBLEM_LINK">Click here</a>
 * Difficulty: $DIFFICULTY
 * Tags: ${TAGS:-$CATEGORY}
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */
public class $CLASS_NAME {

}
EOF

echo "✅ Created: $FILEPATH"
