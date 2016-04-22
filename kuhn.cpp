#include <cstdio>
#include <cstring>
#include <vector>

using namespace std;

const int MAXN = (int) 1e5;
vector <int> g[MAXN];
int px[MAXN];
int py[MAXN];
bool used[MAXN];
int n;

bool try_kuhn(int v) {
    if (used[v]) return false;
    used[v] = 1;
    for (int i = 0; i < (int) g[v].size(); i++) {
        int to = g[v][i];
        if (py[to] == -1 || try_kuhn(py[to])) {
            px[v] = to;
            py[to] = v;
            return true;
        }
    }
    return false;
}

int main() {
    memset(px, -1, sizeof px);
    memset(py, -1, sizeof py);
    for (int i = 0; i < n; i++) {
        memset(used, 0, sizeof used);
        try_kuhn(i);
    }
}

