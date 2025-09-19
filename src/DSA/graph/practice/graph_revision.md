# Breadth First Search (BFS)

**Problem Link:** [LeetCode / GFG BFS Problems](https://www.youtube.com/@takeUforward)
**YouTube Explanation:** [Take U Forward](https://www.youtube.com/@takeUforward)

## Approach / Intuition

* BFS explores a graph level by level using a queue.
* Start from the source node (commonly node 0).
* Mark the starting node as visited.
* For each node, enqueue all unvisited neighbors.
* Continue until the queue is empty.
* BFS is ideal for finding the shortest path in unweighted graphs.

**Key Idea:** BFS guarantees the shortest distance from the source in an unweighted graph.

## Pseudocode

```
function BFS(V, adj):
    result = empty list
    queue = empty queue
    visited = array of size V initialized to False

    enqueue starting node (0) into queue
    visited[0] = True

    while queue is not empty:
        node = dequeue from queue
        add node to result

        for each neighbor in adj[node]:
            if neighbor is not visited:
                enqueue neighbor
                mark neighbor as visited

    return result
```

## Time Complexity

* **O(V + E)**

  * Each vertex is visited once, and each edge is processed once.

## Space Complexity

* **O(V)**

  * The queue stores up to V nodes in the worst case.
  * Visited array also consumes O(V) space.

## Revision-Friendly Notes

* BFS explores nodes in **layers** — think of it as a wave moving outward from the source.
* Always mark nodes as visited **when enqueuing**, not when dequeuing, to avoid revisiting.
* BFS is often paired with a **distance array** to compute shortest paths.
* Can be generalized to **multiple sources** by enqueueing all starting nodes.
* Use BFS for **connected component checks**, shortest path in unweighted graphs, and level order traversals in trees.

---
---

# Depth First Search (DFS)

**Problem Link:** [LeetCode / GFG DFS Problems](https://www.youtube.com/@takeUforward)
**YouTube Explanation:** [Take U Forward](https://www.youtube.com/@takeUforward)

## Approach / Intuition

* Perform a recursive depth-first search starting from node 0.
* Mark each visited node using a boolean array to avoid revisiting.
* Explore as deep as possible along each branch before backtracking.

**Use Cases:**

* Graph traversal
* Cycle detection
* Topological sorting
* Solving puzzles or games with backtracking

**Key Idea:** DFS dives deep along a path before backtracking, exploring one branch completely before moving to another.

## Pseudocode

```
function DFSOfGraph(V, adj):
    result = empty list
    visited = array of size V initialized to False

    DFS(node=0, adj, visited, result)
    return result

function DFS(node, adj, visited, result):
    visited[node] = True
    add node to result

    for each neighbor in adj[node]:
        if neighbor is not visited:
            DFS(neighbor, adj, visited, result)
```

## Time Complexity

* **O(V + E)**

  * Each vertex and edge is visited exactly once.

## Space Complexity

* **O(V)**

  * `visited[]` array uses O(V).
  * Recursion stack can go up to O(V) in worst case.

## Revision-Friendly Notes

* DFS can start from any node; for disconnected graphs, iterate over all nodes.
* Always mark nodes as visited to avoid cycles and infinite recursion.
* DFS is useful in **connected components**, **cycle detection**, and **backtracking problems**.
* Remember the recursion stack contributes to space complexity.
* This pattern generalizes to **tree traversal** and \*\*graph

---
---

# Number Of Provinces

**Problem Link:** [LeetCode - Number Of Provinces](https://leetcode.com/problems/number-of-provinces/description/)
**YouTube Explanation:** [Take U Forward](https://www.youtube.com/@takeUforward)

## Approach / Intuition

* Treat the `isConnected` matrix as a graph adjacency matrix.
* Each city is a node, and `isConnected[i][j] == 1` indicates a direct connection.
* Use Depth-First Search (DFS) to mark all cities in the same connected component (province).
* Count the number of DFS initiations — each corresponds to one province.

**Key Idea:** Each DFS call explores all cities connected directly or indirectly to a starting city, effectively identifying one province.

## Pseudocode

```
function findCircleNum(isConnected):
    n = length of isConnected
    visited = array of size n initialized to False
    provinceCount = 0

    for i in 0 to n-1:
        if not visited[i]:
            DFS(i, isConnected, visited)
            provinceCount += 1

    return provinceCount

function DFS(city, isConnected, visited):
    visited[city] = True
    for neighbor in 0 to n-1:
        if isConnected[city][neighbor] == 1 and not visited[neighbor]:
            DFS(neighbor, isConnected, visited)
```

## Time Complexity

* **O(n^2)**

  * We traverse the `n x n` adjacency matrix.

## Space Complexity

* **O(n)**

  * `visited[]` array uses O(n).
  * DFS recursion stack can go up to O(n) in worst case.

## Revision-Friendly Notes

* DFS can identify **connected components** in an adjacency matrix.
* Count the number of DFS calls — this directly gives the number of provinces.
* Mark nodes as visited immediately to avoid revisiting.
* This pattern generalizes to **social network connectivity**, **island counting**, and **component detection** problems.

---
*** ***
---

# Number Of Islands

**Problem Link:** [LeetCode - Number Of Islands](https://leetcode.com/problems/number-of-islands/description/)
**YouTube Explanation:** [Take U Forward](https://www.youtube.com/@takeUforward)

## Approach / Intuition

* Treat the 2D grid as a graph where each '1' (land) is a node.
* Use Depth-First Search (DFS) to explore all connected land cells.
* Maintain a `visited[][]` array to track visited cells.
* Iterate through each cell:

  * If a cell is land ('1') and not visited, launch DFS from that cell.
  * Mark all reachable land cells as visited — one DFS equals one island.
* Count DFS initiations for the total number of islands.

**Key Idea:** DFS ensures all connected land is visited in one call, preventing double-counting.

## Pseudocode

```
function numIslands(grid):
    if grid is empty:
        return 0

    m, n = dimensions of grid
    visited = 2D array of size m x n initialized to False
    count = 0

    for i in 0 to m-1:
        for j in 0 to n-1:
            if grid[i][j] == '1' and not visited[i][j]:
                DFS(i, j)
                count += 1

    return count

function DFS(i, j):
    if i or j out of bounds OR grid[i][j] != '1' OR visited[i][j]:
        return

    visited[i][j] = True

    for each direction (down, up, right, left):
        DFS(new_i, new_j)
```

## Time Complexity

* **O(m × n)**

  * Each cell is visited once; DFS does constant work per cell.

## Space Complexity

* **O(m × n)**

  * `visited[][]` array uses O(m × n) space.
  * DFS recursion stack can go as deep as O(m × n) in worst case (all land).

## Revision-Friendly Notes

* Always check **boundary conditions** in DFS.
* Using a **visited array** is safer if the input must remain unchanged.
* Count DFS initiations, not individual cells.
* Directions can be represented as `dirs = [[1,0], [-1,0], [0,1], [0,-1]]`.
* This pattern generalizes to \*\*connected componen

---
---
---
# Flood Fill

**Problem Link:** [LeetCode - Flood Fill](https://leetcode.com/problems/flood-fill/description/)
**YouTube Explanation:** [Take U Forward](https://www.youtube.com/@takeUforward)

## Approach / Intuition

* Use Depth-First Search (DFS) starting from the given pixel `(sr, sc)`.
* Only continue DFS on neighboring pixels that have the same color as the original starting pixel.
* Update each visited pixel to the new color.
* Maintain a `visited[][]` array to avoid revisiting pixels.

**Key Idea:** DFS explores all connected pixels of the same color and updates them in one traversal.

## Pseudocode

```
function floodFill(image, sr, sc, newColor):
    m, n = dimensions of image
    result = deep copy of image
    originalColor = image[sr][sc]
    if originalColor == newColor: return result

    visited = 2D array of size m x n initialized to False
    DFS(sr, sc, originalColor, newColor, visited, result)

    return result

function DFS(i, j, originalColor, newColor, visited, image):
    if i or j out of bounds OR visited[i][j] OR image[i][j] != originalColor:
        return

    visited[i][j] = True
    image[i][j] = newColor

    for each direction (down, up, right, left):
        DFS(new_i, new_j, originalColor, newColor, visited, image)
```

## Time Complexity

* **O(m × n)**

  * In the worst case, we may visit every pixel once.

## Space Complexity

* **O(m × n)**

  * `visited[][]` array uses O(m × n) space.
  * DFS recursion stack can go up to O(m × n) in worst case.

## Revision-Friendly Notes

* Always check **boundary conditions** in DFS.
* Avoid revisiting pixels by using a `visited` array.
* If `originalColor` is the same as `newColor`, return early to prevent unnecessary recursion.
* Directions can be represented as `dirs = [[1,0], [-1,0], [0,1], [0,-1]]`.
* This pattern generalizes to **connected region coloring** pro

---
---
---
# Rotting Oranges

**Problem Link:** [LeetCode 994 - Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)
**YouTube Explanation:** [Take U Forward](https://www.youtube.com/@takeUforward)

## Approach / Intuition

* Perform **multi-source BFS** starting from all initially rotten oranges (value = 2).
* Add all rotten oranges to a queue and count the total number of fresh oranges.
* For each minute (BFS level), rot any adjacent fresh oranges (value = 1).
* Increment minutes counter if any fresh orange rots in this round.
* At the end, if any fresh orange remains, return -1; otherwise return total minutes.

**Key Idea:** BFS level represents time passing; multi-source BFS ensures simultaneous rotting from all rotten oranges.

## Pseudocode

```
function orangesRotting(grid):
    if grid is empty: return -1

    queue = empty queue
    freshCnt = 0

    for each cell in grid:
        if cell == 2: enqueue position into queue
        else if cell == 1: freshCnt += 1

    if freshCnt == 0: return 0

    minutes = 0
    directions = [(1,0), (-1,0), (0,1), (0,-1)]

    while queue not empty:
        size = queue.size()
        rottenInThisRound = False

        for i in 0 to size-1:
            r, c = dequeue
            for dr, dc in directions:
                newRow = r + dr, newCol = c + dc
                if newRow,newCol in bounds and grid[newRow][newCol] == 1:
                    grid[newRow][newCol] = 2
                    enqueue (newRow,newCol)
                    freshCnt -= 1
                    rottenInThisRound = True

        if rottenInThisRound: minutes += 1

    return minutes if freshCnt == 0 else -1
```

## Time Complexity

* **O(m \* n)**

  * Each cell is visited at most once.

## Space Complexity

* **O(m \* n)**

  * Queue can contain all grid cells in worst case.

## Revision-Friendly Notes

* Multi-source BFS is essential for simultaneous propagation problems.
* Track the number of fresh oranges to detect when complete rotting occurs.
* BFS levels correspond to time/minutes.
* Directions are always `[down, up, right, left]` to simplify grid traversal.
* This pattern generalizes to \*\*spread/infection/tim


---
---
---
# Detect Cycle in an Undirected Graph

**Problem Link:** [GFG - Detect Cycle in an Undirected Graph](https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1)
**YouTube Explanation:** [Take U Forward](https://www.youtube.com/@takeUforward)

## Approach / Intuition

* Convert the edge list into an adjacency list to represent the graph.
* Traverse each connected component using **BFS** or **DFS**.
* Track the parent of each node to differentiate a valid bidirectional edge from a cycle.
* If a visited node is found that is **not the parent**, a cycle exists.
* Return true if any cycle is detected; otherwise, false.

**Key Idea:** Using parent tracking ensures that revisiting a node via a bidirectional edge is not mistaken for a cycle.

## Pseudocode (BFS)

```
function isCycle(V, edges):
    vis = array of size V initialized to False
    adjList = adjacency list from edges

    for i in 0 to V-1:
        if not vis[i]:
            if detectCycleBFS(adjList, i, vis):
                return True
    return False

function detectCycleBFS(adjList, src, vis):
    queue = empty queue
    mark vis[src] = True
    enqueue (src, parent = -1)

    while queue not empty:
        node, parent = dequeue
        for neighbor in adjList[node]:
            if not vis[neighbor]:
                vis[neighbor] = True
                enqueue (neighbor, node)
            else if neighbor != parent:
                return True  // cycle found
    return False
```

## Pseudocode (DFS)

```
function dfs(node, parent, adjList, vis):
    vis[node] = True
    for neighbor in adjList[node]:
        if not vis[neighbor]:
            if dfs(neighbor, node, adjList, vis):
                return True
        else if neighbor != parent:
            return True  // back edge indicates cycle
    return False
```

## Time Complexity

* **O(V + E)**

  * Each vertex and edge is visited once in BFS/DFS.

## Space Complexity

* **O(V + E)**

  * Adjacency list stores edges and visited array uses O(V).
  * BFS queue or DFS recursion stack may go up to O(V).

## Revision-Friendly Notes

* BFS uses a queue with `(node, parent)` pairs to detect cycles.
* DFS uses recursion and parent tracking to detect back edges.
* Always check each connected component separately.
* Pattern generalizes to \*\*undirected graph

---
---
---
# 01 Matrix

**Problem Link:** [LeetCode - 01 Matrix](https://leetcode.com/problems/01-matrix/description/)
**YouTube Explanation:** [Take U Forward](https://www.youtube.com/@takeUforward)

## Approach / Intuition

* Use **multi-source BFS** starting from all cells with 0.
* Push all 0 cells into the queue initially.
* BFS will calculate the minimum distance to the nearest 0 for each cell containing 1.
* Maintain a `visited[][]` array to avoid revisiting cells.

**Key Idea:** BFS level represents distance; starting from all zeros ensures shortest distance is computed for all ones.

## Pseudocode

```
function updateMatrix(mat):
    rows, cols = dimensions of mat
    visited = 2D array of size rows x cols initialized to False
    result = 2D array of same size as mat
    queue = empty queue

    // Push all 0 cells into queue
    for r in 0 to rows-1:
        for c in 0 to cols-1:
            if mat[r][c] == 0:
                visited[r][c] = True
                enqueue (r, c, step=0)

    directions = [(1,0), (-1,0), (0,1), (0,-1)]

    while queue not empty:
        row, col, step = dequeue
        result[row][col] = step

        for dr, dc in directions:
            nrow = row + dr, ncol = col + dc
            if nrow,ncol in bounds and not visited[nrow][ncol]:
                visited[nrow][ncol] = True
                enqueue (nrow, ncol, step+1)

    return result
```

## Time Complexity

* **O(m \* n)**

  * Each cell is visited at most once during BFS.

## Space Complexity

* **O(m \* n)**

  * Queue and visited matrix use O(m \* n) space.

## Revision-Friendly Notes

* Multi-source BFS ensures minimum distance to nearest 0.
* Directions `[down, up, right, left]` simplify neighbor exploration.
* BFS levels correspond to distance from the nearest 0.
* This pattern generalizes to **matrix distance calculation problems**.

---
---
---
# Surrounded Regions

**Problem Link:** [LeetCode - Surrounded Regions](https://leetcode.com/problems/surrounded-regions/description/)
**YouTube Explanation:** [Take U Forward](https://www.youtube.com/@takeUforward)

## Approach / Intuition

* Any 'O' connected to the **boundary** cannot be flipped to 'X'.
* Perform **DFS** from all boundary 'O's and mark them as visited.
* Flip all 'O's that are **not visited** (completely surrounded by 'X') to 'X'.

**Key Idea:** Only 'O's completely enclosed by 'X' should be flipped; boundary-connected 'O's are safe.

## Pseudocode

```
function solve(board):
    rows, cols = dimensions of board
    vis = 2D boolean array of same size

    // Step 1: DFS from boundary 'O's
    for i in 0 to rows-1:
        if board[i][0] == 'O' and not vis[i][0]: dfs(i,0)
        if board[i][cols-1] == 'O' and not vis[i][cols-1]: dfs(i,cols-1)
    for j in 0 to cols-1:
        if board[0][j] == 'O' and not vis[0][j]: dfs(0,j)
        if board[rows-1][j] == 'O' and not vis[rows-1][j]: dfs(rows-1,j)

    // Step 2: Flip unvisited 'O's
    for i in 0 to rows-1:
        for j in 0 to cols-1:
            if board[i][j] == 'O' and not vis[i][j]:
                board[i][j] = 'X'

function dfs(r, c):
    mark vis[r][c] = True
    for each direction (dr, dc) in [(1,0), (-1,0), (0,1), (0,-1)]:
        nr = r + dr, nc = c + dc
        if nr,nc in bounds and board[nr][nc] == 'O' and not vis[nr][nc]:
            dfs(nr, nc)
```

## Time Complexity

* **O(m \* n)** — Each cell visited at most once.

## Space Complexity

* **O(m \* n)** — Visited array + DFS recursion stack in worst case.

## Revision-Friendly Notes

* Boundary 'O's are always safe; interior 'O's may be flipped.
* DFS/BFS traversal is key for marking connected regions.
* Directions `[down, up, right, left]` help navigate the matrix.
* Pattern generalizes to **enclosed region marking** problems.

---
---
---

# Number Of Enclaves

**Problem Link:** [LeetCode - Number Of Enclaves](https://leetcode.com/problems/number-of-enclaves/description/)
**YouTube Explanation:** [Take U Forward](https://www.youtube.com/@takeUforward)

## Approach / Intuition

* Any land cell (`1`) connected to the **boundary** cannot be an enclave.
* Perform **BFS** from all boundary land cells to mark them as visited.
* Count all **unvisited land cells**; these are the enclaves.

**Key Idea:** Only land cells that are completely surrounded by water and not touching boundary are counted.

## Pseudocode

```
function numEnclaves(grid):
    rows, cols = dimensions of grid
    vis = 2D boolean array

    // Step 1: BFS from boundary land cells
    for i in 0..rows-1:
        if grid[i][0] == 1 and not vis[i][0]: bfs(i,0)
        if grid[i][cols-1] == 1 and not vis[i][cols-1]: bfs(i,cols-1)
    for j in 0..cols-1:
        if grid[0][j] == 1 and not vis[0][j]: bfs(0,j)
        if grid[rows-1][j] == 1 and not vis[rows-1][j]: bfs(rows-1,j)

    // Step 2: Count unvisited land cells
    count = 0
    for i in 0..rows-1:
        for j in 0..cols-1:
            if grid[i][j] == 1 and not vis[i][j]: count++

    return count

function bfs(r, c):
    queue = [(r,c)]
    vis[r][c] = True

    while queue not empty:
        cr, cc = queue.pop()
        for dr, dc in directions:
            nr = cr + dr, nc = cc + dc
            if in bounds and grid[nr][nc] == 1 and not vis[nr][nc]:
                vis[nr][nc] = True
                queue.push((nr,nc))
```

## Time Complexity

* **O(m \* n)** — Each cell is visited at most once.

## Space Complexity

* **O(m \* n)** — Visited array + BFS queue in worst case.

## Revision-Friendly Notes

* Boundary land cells are always safe; interior land cells may form enclaves.
* BFS/DFS traversal ensures marking all connected boundary land.
* Directions `[down, up, right, left]` help navigate the grid.
* Pattern generalizes to problems like **capturing regions or marking safe zones**.

---
---
---
# Number of Distinct Islands

## Problem Links
- **Problem Link**: [https://leetcode.com/problems/number-of-distinct-islands/](https://leetcode.com/problems/number-of-distinct-islands/)
- **YouTube Solution**: [https://www.youtube.com/watch?v=c1ZxUHD8rjc](https://www.youtube.com/watch?v=c1ZxUHD8rjc)

## Approach / Intuition
The goal is to count unique island shapes in a grid, where an island is a group of connected 1s (land) surrounded by 0s (water). Two islands are considered distinct if their shapes differ, regardless of their position or rotation. 

- **Key Insight**: Use DFS to explore each island and encode its shape by recording the relative coordinates of each cell with respect to the starting cell. This ensures translation invariance (position doesn't matter).
- Store unique shapes in a HashSet to eliminate duplicates.
- The size of the HashSet gives the number of distinct islands.

## Pseudocode
```plaintext
// Initialize rows, cols, visited array, and a HashSet for unique shapes
rows = grid.length
cols = grid[0].length
visited = boolean[rows][cols]
shapes = new HashSet()

// Iterate through each cell in the grid
for i from 0 to rows-1:
    for j from 0 to cols-1:
        if grid[i][j] == 1 and not visited[i][j]:
            // Initialize a list to store the shape
            shape = new List()
            // Run DFS from (i,j) to encode the island's shape
            dfs(grid, i, j, i, j, shape)
            // Add shape to HashSet as a string
            shapes.add(join(shape, ","))
// Return the size of the HashSet
return shapes.size()

// DFS function to explore island and record relative coordinates
function dfs(grid, row, col, baseRow, baseCol, shape):
    visited[row][col] = true
    // Record relative coordinates (row - baseRow, col - baseCol)
    shape.add((row - baseRow) + ":" + (col - baseCol))
    // Explore all 4 directions (up, down, left, right)
    for each direction (dr, dc):
        newRow = row + dr
        newCol = col + dc
        if newRow in bounds and newCol in bounds and grid[newRow][newCol] == 1 and not visited[newRow][newCol]:
            dfs(grid, newRow, newCol, baseRow, baseCol, shape)
```

## Time Complexity
- **Time Complexity**: O(m * n)
- **Explanation**: 
  - We visit each cell in the grid (m rows × n columns) at most once during the DFS traversal.
  - Each cell is processed in O(1) time for checking boundaries, visited status, and adding to the shape list.
  - String operations (joining the shape list) are negligible as the size of an island is typically much smaller than the grid.
  - Total time is O(m * n) for the entire grid traversal.

## Space Complexity
- **Space Complexity**: O(m * n)
- **Explanation**:
  - **Visited Array**: The `vis` array is a boolean matrix of size m × n, used to track visited cells.
  - **Shape Storage**: Each island’s shape is stored as a list of relative coordinates, and all shapes are stored in a HashSet. In the worst case (e.g., a grid full of 1s forming one large island), the shape list could store O(m * n) coordinates.
  - **Recursion Stack**: DFS recursion depth is proportional to the size of an island, which is at most O(m * n) in the worst case.
  - Total space is O(m * n) due to these components.

## Notes for Revision
- **Key Insight**: Encoding shapes using relative coordinates ensures translation invariance, making islands with the same shape but different positions count as one.
- **Edge Cases**:
  - Empty grid or grid with no land cells (return 0).
  - Single-cell islands (shape is just "0:0").
  - Islands with identical shapes at different positions (HashSet handles deduplication).
- **Pattern**: This is a classic DFS problem with a graph (grid) traversal, combined with a unique encoding technique to compare structures.
- **Common Mistake**: Forgetting to use relative coordinates can lead to counting the same shape at different positions as distinct islands.
- **Tip**: To handle rotations or reflections (not required here), you’d need to normalize the shape further, but relative coordinates suffice for this problem.

---
---
---
